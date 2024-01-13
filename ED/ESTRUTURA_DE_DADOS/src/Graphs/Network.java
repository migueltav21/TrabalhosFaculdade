package Graphs;

import java.util.Iterator;

import Interfaces.NetworkADT;
import Lists.DoublyUnorderedLinkedList;

public class Network<T> extends Graph<T> implements NetworkADT<T> {
    private double[][] weightMatrix; // matriz de pesos

    /**
     * Cria uma rede vazia.
     */
    public Network() {
        super();
        this.weightMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    public Network(int num) {
        super(num);
        this.weightMatrix = new double[num][num];
    }

    /**
     * Insere uma aresta com peso entre dois vértices da rede.
     *
     * @param vertex1 o primeiro vértice
     * @param vertex2 o segundo vértice
     * @param weight  o peso da aresta
     */
    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);

        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
            weightMatrix[index1][index2] = weight;
            weightMatrix[index2][index1] = weight;
        }
    }

    /**
     * Retorna o peso do caminho mais curto nesta rede.
     *
     * @param vertex1 o primeiro vértice
     * @param vertex2 o segundo vértice
     * @return o peso do caminho mais curto nesta rede
     */
    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        int startIndex = getIndex(vertex1);
        int targetIndex = getIndex(vertex2);

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            throw new IllegalArgumentException("Invalid start or target vertex");
        }

        double[] distances = new double[numVertices];
        boolean[] tight = new boolean[numVertices];
        int[] previousVertices = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        // Inicializa as distâncias com infinito, tight como false e os vértices
        // anteriores como -1
        for (int i = 0; i < numVertices; i++) {
            distances[i] = Double.POSITIVE_INFINITY;
            tight[i] = false;
            previousVertices[i] = -1;
            visited[i] = false;
        }

        // A distância até o vértice de partida é 0
        distances[startIndex] = 0;

        while (true) {
            // Encontrar vértice u com tight[u] = false e menor distância estimada D[u]
            int u = -1;
            double minDistance = Double.POSITIVE_INFINITY;

            for (int i = 0; i < numVertices; i++) {
                if (!tight[i] && distances[i] < minDistance) {
                    u = i;
                    minDistance = distances[i];
                }
            }

            if (u == -1) {
                // Todos os vértices estão 'tight'
                break;
            }

            tight[u] = true;

            // Atualizar distâncias para vértices adjacentes a u
            for (int z = 0; z < numVertices; z++) {
                if (adjMatrix[u][z] && !visited[z]) {
                    double newDistance = distances[u] + weightMatrix[u][z];

                    if (newDistance < distances[z]) {
                        distances[z] = newDistance;
                        previousVertices[z] = u;
                    }
                }
            }
        }

        // Retorna o peso do caminho mais curto
        return distances[targetIndex];
    }

    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);
    
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            throw new IllegalArgumentException("Invalid start or target vertex");
        }
    
        double[] distances = new double[numVertices];
        boolean[] tight = new boolean[numVertices];
        int[] previousVertices = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
    
        // Inicializa as distâncias com infinito, tight como false e os vértices
        // anteriores como -1
        for (int i = 0; i < numVertices; i++) {
            distances[i] = Double.POSITIVE_INFINITY;
            tight[i] = false;
            previousVertices[i] = -1;
            visited[i] = false;
        }
    
        // A distância até o vértice de partida é 0
        distances[startIndex] = 0;
    
        while (true) {
            // Encontrar vértice u com tight[u] = false e menor distância estimada D[u]
            int u = -1;
            double minDistance = Double.POSITIVE_INFINITY;
    
            for (int i = 0; i < numVertices; i++) {
                if (!tight[i] && distances[i] < minDistance) {
                    u = i;
                    minDistance = distances[i];
                }
            }
    
            if (u == -1) {
                // Todos os vértices estão 'tight'
                break;
            }
    
            tight[u] = true;
    
            // Atualizar distâncias para vértices adjacentes a u
            for (int z = 0; z < numVertices; z++) {
                if (adjMatrix[u][z] && !visited[z]) {
                    double newDistance = distances[u] + weightMatrix[u][z];
    
                    if (newDistance < distances[z]) {
                        distances[z] = newDistance;
                        previousVertices[z] = u;
                    }
                }
            }
        }
    
        // Construir o caminho mais curto
        DoublyUnorderedLinkedList<T> resultList = new DoublyUnorderedLinkedList<>();
        int currentVertex = targetIndex;
    
        while (currentVertex != -1) {
            resultList.addToFront(vertices[currentVertex]);
            currentVertex = previousVertices[currentVertex];
        }
    
        return resultList.iterator();
    }
}
