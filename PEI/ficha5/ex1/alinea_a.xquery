declare function local:books-by-author($name) as element()*
{
for $b in doc("bookstore.xml")//book
where some $ba in $b//author satisfies ($ba = $name)
order by $b/title
return $b
};
let $n := local:books-by-author("J K. Rowling")
return $n