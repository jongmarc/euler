open (FILE, "<p083_matrix.txt");
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

# convert the matrix to a graph with the destination value as weighted edge
for ($y = 0 ; $y <= $#matrix; $y++) {
	#print $y;
	for ($x = 0; $x <= $#{$matrix[0]}; $x++) {
		#print $x;
		if ($y > 0) {
			$g->add_weighted_edge("$y,$x", ($y-1).",".($x), $matrix[$y - 1][$x]);
			print "Add edge "."$y,$x"." ".($y-1).",".($x)." with weight ".$matrix[$y - 1][$x]."\n";
		}
		if ($y < $#matrix) {
			$g->add_weighted_edge("$y,$x", ($y+1).",".($x), $matrix[$y + 1][$x]);
			print "Add edge "."$y,$x"." ".($y+1).",".($x)." with weight ".$matrix[$y + 1][$x]."\n";
		}
		if ($x > 0) {
			$g->add_weighted_edge("$y,$x", ($y).",".($x-1), $matrix[$y][$x-1]);
			print "Add edge "."$y,$x"." ".($y).",".($x-1)." with weight ".$matrix[$y][$x-1]."\n";
		}
		if ($x < $#{$matrix[0]}) {
			$g->add_weighted_edge("$y,$x", ($y).",".($x+1), $matrix[$y][$x+1]);
			print "Add edge "."$y,$x"." ".($y).",".($x+1)." with weight ".$matrix[$y][$x+1]."\n";
		}
	}
}
$answer = 0;
@path = $g->SP_Dijkstra("0,0", "79,79");
foreach $item (@path){
	
		($y,$x) = split ",", $item;
		print $item." ==> ".$matrix[$y][$x]."\n";
		
			$answer += $matrix[$y][$x];
		
}

print "Answer = ".$answer."\n";
