declare function local:estado-livros() as element()*
{
for $livro in doc("bookstore.xml")//book
let $ano := ($livro/year)
return
<book>
{$livro/*}
<state>{if($ano <= 2010) then "antigo" else "recente"}</state>
</book>
};

let $livros := local:estado-livros()
return $livros