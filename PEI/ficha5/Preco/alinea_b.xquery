let $collection := collection("file:///C:\Faculdade\PEI\ficha5\Preco?select=*.xml")
let $media := avg($collection//preco)
return $media