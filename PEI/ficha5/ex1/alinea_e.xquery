if(some $categoria in doc("bookstore.xml")//book/@category
satisfies($categoria = "CHILDREN"))then doc("bookstore.xml")//book else ("não há livros da categoria CHILDREN")