use bigint;
my %table;
$table{0} = 1; 
$total = 0;

my $i = 10;
while ( 1==1 ) {
	my $sum = 0;
	foreach $digit ( $i=~/./g ) {
		$sum += factorial( $digit );
		last if ($sum > $i);
	}
	if ( $i == $sum ) {
		$total += $i;
		print "Found ".$i." which gives total: ".$total."\n";
	}

	$i++;
}


sub factorial {
    my $number = shift;
    my $factorial;

    if ( exists $table{$number} ) {
        return $table{$number}; # Input found in the look-up table, returning stored value.
    }
     else {
        $factorial = factorial($number - 1) * $number;
    }

    $table{$number} = $factorial; # Inserting newly calculated value into new table.

    return $factorial;
}
