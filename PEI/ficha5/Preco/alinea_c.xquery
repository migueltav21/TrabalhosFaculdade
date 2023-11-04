let $collection := collection("file:///C:\Faculdade\PEI\ficha5\Preco?select=*.xml")
let $produto := $collection//produto
let $lapis := $produto[nome = "lápis"]
let $borracha := $produto[nome = "borracha"]



let $total_lapis := $lapis/preco * 2
let $total_borracha := $borracha/preco
let $total := $total_borracha + $total_lapis
return $total
