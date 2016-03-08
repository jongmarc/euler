$i = 345;

my $found = 0;
while (!$found) {
	$line = join "", reverse sort split //, ($i ** 3);
	$lines{$line}++;
	if ($lines{$line} == 5) {
		$found = $line;
	}
	$i++;	
}

$i = 345;
while (1==1) {
	$line = join "", reverse sort split //, ($i ** 3);
	if ($line == $found) {
		print "Answer = ".($i ** 3)."\n"; 
		exit(0);
	}
	$i++;
}