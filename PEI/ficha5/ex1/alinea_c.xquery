let $count := count(doc("bookstore.xml")//book[xs:integer(year) < 2008])
return $count