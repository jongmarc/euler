use Math::Prime::Util 'partitions';

print partitions(100) - 1;

  __END__

# very very slow versiom

@reeks = ( 20 );
$max = 0;
while ( $reeks[0] != 0 ) {
	if ($#reeks > $max ){
		$max = $#reeks;
		print $#reeks."\n";
	}
	$a = join ",", sort @reeks;
	$answer{$a} = 1;
	$i = $#reeks;
	$add = 0;
	while ( $reeks[$i] == 1 ) {
		$add += pop @reeks;
		$i--;
		if ($i < 0) {
			#done
			@a = keys %answer;
			print "Answer = ".$#a;
			exit(0);
		}
	}
	$reeks[$#reeks]--;
	push @reeks, $add + 1;
}

