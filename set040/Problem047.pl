use ntheory qw/factor forprimes is_prime/;

$i = 1;

while (1==1){
	undef %one;
	undef %two;
	undef %three;
	undef %four;
	if (!is_prime($i) && !is_prime($i+1) && !is_prime($i+2)&& !is_prime($i+3)) {
		#print "Checking ".$i."\n";
		%one = &hashify(factor($i));
		%two = &hashify(factor($i+1));
		%three = &hashify(factor($i+2));
		%four = &hashify(factor($i+3));
		if (scalar keys %one == 4 && scalar keys %two == 4 && scalar keys %three == 4 && scalar keys %four == 4) {
			%combine = (%one, %two, %three, %four);
			print scalar keys %combine;
			print "\n";

			if ( scalar keys %combine == 16) {
				print "Found: $i\n";
				exit(0);
			}
		}
	}
	$i++;

	print $i."\n";
}

sub hashify {
	my @array = @_;

	my %count;
	map { $count{$_}++ } @array;
	my %bla;
	$bla{$_."-".$count{$_}} = 1 foreach sort {$a<=>$b} keys %count;
	return %bla;
}
