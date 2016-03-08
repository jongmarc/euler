$i = 2;

while (1 == 1) {
	if (length($i) == length($i*2) &&
	 	length($i) == length($i*3) &&
	 	length($i) == length($i*4) &&
	 	length($i) == length($i*5) &&
	 	length($i) == length($i*6)) {
		# alle zes de lengtes gelijk
		if (&equalize($i) == &equalize($i * 2) &&
			&equalize($i) == &equalize($i * 3) &&
			&equalize($i) == &equalize($i * 4) &&
			&equalize($i) == &equalize($i * 5) &&
			&equalize($i) == &equalize($i * 6)) {
			print "Answer = ".$i."\n";
			exit(0);
		}
	}
	$i++;
	#print $i."\n";
	if ($i > 1000000) {
		exit(0);
	}
}


sub equalize {
	my $string = shift;
	return join "", sort split //, $string;
}