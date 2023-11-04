for $produto in db:open("Preco")//produto
where not(exists($produto/desconto))
return $produto/nome
