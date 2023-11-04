declare function local:deduzirTaxaAeroporto($abreviatura as xs:string) as xs:double? {
  let $documento := doc("voos.xml")
  let $aeroporto := $documento//aeroporto[@abreviatura = $abreviatura]
  return if ($aeroporto) then
    let $taxaOriginal := xs:double($aeroporto/taxa)
    let $taxaDeduzida := $taxaOriginal - ($taxaOriginal * 0.1)
    return $taxaDeduzida
  else ()
};

let $abreviatura := "LHR"
return local:deduzirTaxaAeroporto($abreviatura)
