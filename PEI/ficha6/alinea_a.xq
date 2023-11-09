let $req := http:send-request(<http:request method='get'
 json='format=xquery,lax=true'/>,
 "http://ip-api.com/xml/")
return $req[2]