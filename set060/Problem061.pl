
# generate triangle
$sum = 1; $inc = 2;
while ( $sum < 10000 ) {
	push @triangle, $sum if $sum > 1000;
	$sum += $inc++;
}


# generate square
$sum = 1; $inc = 1;
while ( $sum < 10000 ) {
	push @square, $sum if $sum > 999;
	$sum += $inc += 2;
}

# generate pentagonal
$sum = 1; $inc = 1;
while ( $sum < 10000 ) {
	push @pentagonal, $sum if $sum > 999;
	$sum += $inc += 3;
}

# generate hexagonal
$sum = 1; $inc = 1;
while ( $sum < 10000 ) {
	push @hexagonal, $sum if $sum > 999;
	$sum += $inc += 4;
}

# generate heptagonal
$sum = 1; $inc = 1;
while ( $sum < 10000 ) {
	push @heptagonal, $sum if $sum > 999;
	$sum += $inc += 5;
}
	
# generate octagonal
$sum = 1; $inc = 1;
while ( $sum < 10000 ) {
	push @octagonal, $sum if $sum > 999;
	$sum += $inc += 6;
}

#clean numbers that cannot reference

for ($j = 0;$j < 3; $j++) {
	# print $#triangle.",".$#square.",".$#pentagonal.",".$#hexagonal.",".$#heptagonal.",".$#octagonal."\n";

	$triangle = "-".(join "-", @triangle)."-";	
	$square = "-".(join "-", @square)."-";
	$pentagonal = "-".(join "-", @pentagonal)."-";
	$hexagonal = "-".(join "-", @hexagonal)."-";
	$heptagonal = "-".(join "-", @heptagonal)."-";
	$octagonal = "-".(join "-", @octagonal)."-";

	@triangle = validateNumbers($square.$pentagonal.$hexagonal.$heptagonal.$octagonal, @triangle);
	@square = validateNumbers($triangle.$pentagonal.$hexagonal.$heptagonal.$octagonal, @square);
	@pentagonal = validateNumbers($triangle.$square.$hexagonal.$heptagonal.$octagonal, @pentagonal);
	@hexagonal = validateNumbers($triangle.$square.$pentagonal.$heptagonal.$octagonal, @hexagonal);
	@heptagonal = validateNumbers($triangle.$square.$pentagonal.$hexagonal.$octagonal, @heptagonal);
	@octagonal = validateNumbers($triangle.$square.$pentagonal.$hexagonal.$heptagonal, @octagonal);

	# print $#triangle.",".$#square.",".$#pentagonal.",".$#hexagonal.",".$#heptagonal.",".$#octagonal."\n";
}

	my $total  = "-".(join ",1-", @triangle).",1-";	
	$total .= "-".(join ",2-", @square).",2-";
	$total .= "-".(join ",3-", @pentagonal).",3-";
	$total .= "-".(join ",4-", @hexagonal).",4-";
	$total .= "-".(join ",5-", @heptagonal).",5-";
	#$total .= "-".(join ",6-", @octagonal).",6-";

$answer = 0;
for ( $i=0; $i <= $#octagonal; $i++) {
	&show($octagonal[$i], $octagonal[$i], $total, "6")."\n";
}
print "-----\n".$answer." (answer)\n";

sub show {
	my ($original, $number, $total, $exclude) = @_;
	my $end = substr($number, -2);
	if (length($exclude) == 6) {
		if (substr($original, 0, 2) == $end ) {
			print $number."\n";
			$answer = $number;
			return 1;
		}
	}
	while ($total =~ s/-($end\d\d),([^$exclude])//) {
		#print $1.",".$2."\n";
		if ( &show($original, $1, $total, $exclude.$2) ) {
			print $number."\n";
			$answer += $number;
			return 1;
		}
	}
	return 0;
}

sub validateNumbers {
	($numberString, @array) = @_;
	my @temp;
	for ( my $i = 0; $i <= $#array; $i++ ) {
		my $end = substr($array[$i], -2);
		if ( $numberString =~ /-$end/ ) {
			push @temp, $array[$i];

		}
	}
	return @temp;
}

		
