let $collection := collection("file:///C:\Faculdade\PEI\ficha5\Preco?select=*.xml")
let $produtos_sem_desconto := (
for $produto in $collection//produto where not(exists($produto/desconto))
return $produto)
return $produtos_sem_desconto