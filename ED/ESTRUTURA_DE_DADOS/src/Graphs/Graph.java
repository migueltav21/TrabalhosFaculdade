package Graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Interfaces.GraphADT;
import Lists.DoublyUnorderedLinkedList;
import Queues.LinkedQueue;
import Stacks.LinkedStack;

/**
 * Graph represents an adjacency matrix implementation of a graph.
 *
 */
public class Graph<T> implements GraphADT<T> {
    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);

    }

    public Graph(int num) {
        numVertices = 0;
        this.adjMatrix = new boolean[num][num];
        this.vertices = (T[]) (new Object[num]);

    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public void addEdge(T vertex1, T vertex2) {
        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);
    
        if (!indexIsValid(index1) || !indexIsValid(index2)) {
            throw new IllegalArgumentException("Invalid vertex: " + vertex1 + " or " + vertex2);
        }
    
        adjMatrix[index1][index2] = true;
        adjMatrix[index2][index1] = true;
    }
    /**
     * Adds a vertex to the graph, expanding the capacity of the graph
     * if necessary. It also associates an object with the vertex.
     *
     * @param vertex the vertex to add to the graph
     */
    public void addVertex(T vertex) {

        if (contains(vertex)) {
            throw new IllegalArgumentException("Vertex already exists in the graph: " + vertex);
        }
    
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = vertex;

        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }

        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) {
        int index = getIndex(vertex);

        if (indexIsValid(index)) {
            // Remover da lista de vértices
            for (int i = index; i < numVertices - 1; i++) {
                vertices[i] = vertices[i + 1];
            }

            // Atualizar a matriz de adjacências
            for (int i = index; i < numVertices - 1; i++) {
                for (int j = 0; j < numVertices; j++) {
                    adjMatrix[i][j] = adjMatrix[i + 1][j];
                }
            }

            for (int i = 0; i < numVertices; i++) {
                for (int j = index; j < numVertices - 1; j++) {
                    adjMatrix[i][j] = adjMatrix[i][j + 1];
                }
            }

            // Limpar a última coluna e linha
            for (int i = 0; i < numVertices; i++) {
                adjMatrix[i][numVertices - 1] = false;
                adjMatrix[numVertices - 1][i] = false;
            }

            numVertices--;
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);

        if (!indexIsValid(index1) || !indexIsValid(index2)) {
            throw new IllegalArgumentException("Invalid vertex for edge removal");
        }

        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        }
    }

@Override
public Iterator<T> iteratorBFS(T startVertex) {
    if (!contains(startVertex)) {
        throw new IllegalArgumentException("Start vertex not found in the graph");
    }

    LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
    DoublyUnorderedLinkedList<T> resultList = new DoublyUnorderedLinkedList<>();
    boolean[] visited = new boolean[numVertices];

    int startIndex = getIndex(startVertex);
    for (int i = 0; i < numVertices; i++) {
        visited[i] = false;
    }

    traversalQueue.enqueue(startIndex);
    visited[startIndex] = true;

    while (!traversalQueue.isEmpty()) {
        int x = traversalQueue.dequeue();
        resultList.addToRear(vertices[x]);

        // Encontre todos os vértices adjacentes a x que não foram visitados e coloque-os na fila
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[x][i] && !visited[i]) {
                traversalQueue.enqueue(i);
                visited[i] = true;
            }
        }
    }

    return resultList.iterator();
}


    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        if (!contains(startVertex)) {
            throw new IllegalArgumentException("Start vertex not found in the graph");
        }

        LinkedStack<Integer> traversalStack = new LinkedStack<>();
        DoublyUnorderedLinkedList<T> resultList = new DoublyUnorderedLinkedList<>();
        boolean[] visited = new boolean[numVertices];

        int startIndex = getIndex(startVertex);
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(startIndex);
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            int x = traversalStack.peek();
            boolean found = false;

            // Encontre um vértice adjacente a x que não foi visitado e coloque-o na pilha
            for (int i = 0; i < numVertices && !found; i++) {
                if (adjMatrix[x][i] && !visited[i]) {
                    traversalStack.push(i);
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }

            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }

        return resultList.iterator();
    }

    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);
    
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            throw new IllegalArgumentException("Invalid start or target vertex");
        }
    
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<>();
        DoublyUnorderedLinkedList<T> resultList = new DoublyUnorderedLinkedList<>();
        boolean[] visited = new boolean[numVertices];
        int[] previousVertices = new int[numVertices];
    
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
            previousVertices[i] = -1;
        }
    
        traversalQueue.enqueue(startIndex);
        visited[startIndex] = true;
    
        while (!traversalQueue.isEmpty()) {
            int currentVertex = traversalQueue.dequeue();
    
            if (currentVertex == targetIndex) {
                // Construir o caminho mais curto se o vértice de destino for alcançado
                int backtrackVertex = targetIndex;
                while (backtrackVertex != -1) {
                    resultList.addToFront(vertices[backtrackVertex]);
                    backtrackVertex = previousVertices[backtrackVertex];
                }
    
                return resultList.iterator();
            }
    
            for (int adjacentVertex = 0; adjacentVertex < numVertices; adjacentVertex++) {
                if (adjMatrix[currentVertex][adjacentVertex] && !visited[adjacentVertex]) {
                    traversalQueue.enqueue(adjacentVertex);
                    visited[adjacentVertex] = true;
                    previousVertices[adjacentVertex] = currentVertex;
                }
            }
        }
    
        // Se chegarmos aqui, não há caminho entre os vértices
        return resultList.iterator(); // Lista vazia
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isConnected'");
    }

    @Override
    public int size() {
        return numVertices;
    }

    private void expandCapacity() {
        boolean[][] newMatrix = new boolean[adjMatrix.length * 2][adjMatrix.length * 2];
        for (int i = 0; i < numVertices; i++) {
            System.arraycopy(adjMatrix[i], 0, newMatrix[i], 0, numVertices);
        }
        adjMatrix = newMatrix;
    }

    public int getIndex(T vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }

        throw new NoSuchElementException("Vertex not found: " + vertex);
    }

    protected boolean indexIsValid(int index) {
        return index >= 0 && index < numVertices;
    }

    protected boolean contains(T vertex) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null && vertices[i].equals(vertex)) {
                return true;
            }
        }
        return false;
    }    

}