use bignum;
$i = 1;
$p = 3;
$q = 2; 
$answer=0;
for ($i; $i <=1000;$i++) {
	$t = $p;
	$p = $p + 2 * $q;
	$q = $t + $q;
	print $i."\t".$p."\t".$q."\n";
	if (length($p) > length($q)) {
		$answer++;
	}

}
print $answer;