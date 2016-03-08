$i=3;

while (1==1) {
    $found = 0;
    if (! &isPrime($i)) {
        # is composite number
        for ($j = 1; $j < $i; $j+= 2) {
            if (&isPrime($j)) {
                # part is prime
                $k = $i - $j;
                if ( $k % 2 == 0 ) {
                    $l = $k / 2;
                    if ( sqrt($l) == int(sqrt($l)) ) {
                        $found = 1;
                        print $i." = ".$j." + 2x".sqrt($l)."^2\n";
                        last;
                    }

                }
            }
        }
    } else {
        $found = 1;
    }
    if ($found == 0) {
        print "Answer = ".$i."\n";
        exit(0);
    }
    $i+=2;
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