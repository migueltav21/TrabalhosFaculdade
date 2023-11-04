if(every $preco in doc("bookstore.xml")//book/price
satisfies($preco < 60))then doc("bookstore.xml")//book else ("existem livros a custar mais de 60 euros")