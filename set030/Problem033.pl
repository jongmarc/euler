
$foundN = 1;
$foundD = 1;
for ($d = 10; $d <= 99; $d++) {
	for ($n = 10; $n < $d; $n++){
		($n1, $n2) = $n =~ /(\d)(\d)/;
		($d1, $d2) = $d =~ /(\d)(\d)/;
		if ($n1 == $d2 && $d1 != 0) {
			if ($n2 / $d1 == $n / $d) {
				print $n."/".$d."\n";
				$foundN *= $n;
				$foundD *= $d;
			}
		}
		if ($n2 == $d1 && $d2 != 0) {
			if ($n1 / $d2 == $n / $d) {
				print $n."/".$d."\n";
				$foundN *= $n;
				$foundD *= $d;

			}
		}
	}
}

print 38729600 / 387296;
