let $voos := doc("voos.xml")//voos
for $voo in $voos//voo
where contains($voo//@id, "FR")
return
<voo id="{$voo//@id}">
<origem>{$voo//origem}</origem>
<destino>{$voo//destino}</destino>
</voo>