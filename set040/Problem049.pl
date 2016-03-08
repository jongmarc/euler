use ntheory qw/factor forprimes is_prime/;
#print &equalize(1001); exit(0);
for ($i = 1001; $i < 9998; $i+=2) {
	if ($i != 1487) {
		if (is_prime($i)) {
			for ($j = $i + 2; $j < 9999; $j+=2) {
				if (is_prime($j)) {
					$k = $j + ($j - $i);
					if ($k < 10000 && is_prime($k)) {
						$a = &equalize($i);
						$b = &equalize($j);
						$c = &equalize($k);
						print $i."-".$j."-".$k."\n";
						if (&equalize($i) == &equalize($j) && &equalize($i) == &equalize($k)) {
							print "Answer = ".$i.$j.$k."\n";
							exit(0);
						}
					}
				
				}
			}
		}
	}
}


sub equalize {
	my $string = shift;
	return join "", sort $string =~ /(\d)(\d)(\d)(\d)/;
}