use POSIX;

$sum = 0;
$i = 11;
$found = 0;
while ($found < 11) {
    $k = 1;
    foreach $bla ( &trunc($i) ) {
        
        if ( !isPrime($bla) ) {
            $k = 0;
            last;
        }
    }
    if ($k == 1) {
        print $i."\n";
        $found++;
        $sum = $sum + $i;

    }
    $i++;
}
print "Answer = ".$sum."\n";


sub trunc {
    my $number = shift;
    undef @list;
    $a = $number;
    while (length($a) > 0) {
        push(@list, $a);
        $a = substr($a, 0, length($a)-1);
    }
    $a = $number;
    $a = substr($a, 1);
    while (length($a) > 0) {
        push(@list, $a);
        $a = substr($a, 1);
    }
    
    return @list;
}



sub isPrime {
    my $number = shift;
    if ($number==1) {return 0};
    if ($number==2) {return 1};
    my $d = 2;
    my $sqrt = sqrt $number;
    while(1) {
        if ($number%$d == 0) {
            return 0;
        }
        if ($d < $sqrt) {
            $d++;
        } else {
            return 1;
        }
    }
}