let $req := http:send-request(<http:request method='get'
 json='format=xquery,lax=true'/>,
 "http://ip-api.com/xml/77.54.134.194?fields=country,continent")
return $req[2]