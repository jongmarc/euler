open (FILE, "<p081_matrix.txt");
$y = 0;
while ($line = <FILE>) {
	@items = 
	$x = 0;
	foreach $item ( split /,/, $line ) {
		$matrix[$y][$x++] = $item;
	}
	$y++;
}
close (FILE);

# $matrix[0] = [131, 673,234,103,18];
# $matrix[1] = [201,96,342,965,150];
# $matrix[2] = [630,803,746,422,111];
# $matrix[3] = [537,699,497,121,956];
# $matrix[4] = [805,732,524,37,331];

for ($y = $#matrix; $y >= 0; $y--) {
	for ($x = $#{$matrix[$y]}; $x >= 0; $x--) {
		if ( !( $x == $#{$matrix[$y]} && $y == $#matrix) ) {
			if ( $x == $#{$matrix[$y]} ) {
				$matrix[$y][$x] += $matrix[$y + 1][$x];	
			} elsif ( $y == $#matrix ) {
				$matrix[$y][$x] += $matrix[$y][$x + 1];
			} else {
				if ($matrix[$y][$x + 1] < $matrix[$y + 1][$x]) {
					$matrix[$y][$x] += $matrix[$y][$x + 1];
				} else{
					$matrix[$y][$x] += $matrix[$y + 1][$x];
				}
			}
		}
	}
}
print "Answer = ".$matrix[0][0]."\n";
