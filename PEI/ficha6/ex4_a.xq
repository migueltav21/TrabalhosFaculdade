module namespace bookstore-api = 'http://example.com/bookstore';

declare %rest:path("/books-by-author")
%rest:GET
function bookstore-api:getBooksByAuthor($authorName as xs:string) {
  let $books :=
    for $book in doc('C:\Faculdade\PEI\ficha6')//book
    where $book/author = $authorName
    return $book

  return
    <bookstore>
      { $books }
    </bookstore>
}; 

