let $total := sum(db:open("Preco")//produto/preco)
let $count := count(db:open("Preco")//produto)
return $total div $count