
$t = 3;
$p = 5;
$h = 6;

while (1==1) {
		
	if (&triangle($t) == &pentagonal($p) && &triangle($t) == &hexagonal($h) && &triangle($t) > 40755) {
		print "Found ".&triangle($t).", ".&pentagonal($p).", ".&hexagonal($h)."\n";
		exit(0);
	}

	$found = 0;
	if (&triangle($t) > &pentagonal($p)) {
		$p++;
		$found = 1;
	}
	if (&triangle($t) > &hexagonal($h)) {
		$h++;
		$found = 1;
	}

	if (! $found) {
		$t++;
	}
}	

sub triangle {
	my $i = shift;
	return $i * ($i + 1) / 2;
}

sub pentagonal {
	my $i = shift;
	return $i * (3 * $i - 1) / 2;
}

sub hexagonal {
	my $i = shift;
	return $i * (2 * $i - 1);
}