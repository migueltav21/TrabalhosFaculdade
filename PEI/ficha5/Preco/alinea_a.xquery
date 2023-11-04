let $collection := collection("file:///C:\Faculdade\PEI\ficha5\Preco?select=*.xml")

for $produto in $collection/produtos/produto
let $nome := $produto/nome
let $preco := xs:decimal($produto/preco)
let $desconto := xs:decimal($produto/desconto)

order by $preco * (1 - ($desconto div 100)) ascending
return $nome