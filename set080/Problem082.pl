open (FILE, "<p082_matrix.txt");
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

use Graph::Directed;
my $g = Graph::Directed->new; # An undirected graph.

# Add source and destination nodes with 0 weight
for ($y=0; $y <= $#matrix; $y++) {
	$g->add_weighted_edge("A", "$y,0", 0 );
	my $z = $#{$matrix[$y]}; print $z;
	$g->add_weighted_edge("$y,$z", "Z", 0 );
}

# convert the matrix to a graph with the destination value as weighted edge
for ($y = 0 ; $y <= $#matrix; $y++) {
	#print $y;
	for ($x = 0; $x <= $#{$matrix[0]} - 1; $x++) {
		#print $x;
		if ($y > 0) {
			$g->add_weighted_edge("$y,$x", ($y-1).",".($x), $matrix[$y - 1][$x]);
			print "Add edge "."$y,$x"." ".($y-1).",".($x)." with weight ".$matrix[$y - 1][$x]."\n";
		}
		if ($y < $#matrix) {
			$g->add_weighted_edge("$y,$x", ($y+1).",".($x), $matrix[$y + 1][$x]);
			print "Add edge "."$y,$x"." ".($y+1).",".($x)." with weight ".$matrix[$y + 1][$x]."\n";
		}
		$g->add_weighted_edge("$y,$x", ($y).",".($x+1), $matrix[$y][$x+1]);
		print "Add edge "."$y,$x"." ".($y).",".($x+1)." with weight ".$matrix[$y][$x+1]."\n";
	}
}
$answer = 0;
@path = $g->SP_Dijkstra("A", "Z");
foreach $item (@path){
	
		($y,$x) = split ",", $item;
		print $item." ==> ".$matrix[$y][$x]."\n";
		if ( length($item) > 1) {
			$answer += $matrix[$y][$x];
		}
}

print "Answer = ".$answer."\n";
