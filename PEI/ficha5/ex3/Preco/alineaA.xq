for $produto in db:open("Preco")//produto
let $nome := $produto/nome
let $preco := xs:decimal($produto/preco)
let $desconto := xs:decimal($produto/desconto)
order by $preco * (1 - ($desconto div 100)) descending
return $nome
