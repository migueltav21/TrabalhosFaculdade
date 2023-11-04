let $voos := doc("voos.xml")//voos
for $a in $voos//voo
return $a[contains($a//@id, "FR")]