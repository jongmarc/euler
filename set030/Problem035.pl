use POSIX;

$z=1;
for ($i = 2; $i < 1000000; $i++) {
    $k = 1;
    $l = $i;
    for ($j = 0; $j < length($l); $j++) {
        if (!isPrime($l)) {
            $k = 0;
        }
        $l = &rotate($l);
    }
    if ($k == 1) {
        print $i."\n";
        $z++;
    }
}
print "Answer = ".$z."\n";

sub rotate {
    my ($a) = @_;
    if ($a < 10) {
        return $a;
    }
    else {
        return $a % 10 . floor($a / 10);
    }
}

sub isPrime {
    my $number = shift;
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