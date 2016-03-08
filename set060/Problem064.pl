use POSIX;

my $n = 2;
my $answer = 0;

while ($n <= 10000) {
        my $check = check($n);
        $answer++ if $check and $check % 2;
        $n++;
}

print "Answer 64 = $answer\n";





sub check {
    my ($check) = @_;

    return 0 if sqrt($check) == floor(sqrt($check));

        my %seen;
    my $floor = floor( sqrt($check));    
    my @res = ($floor); 
    my ($n, $d, $p);
    my $step = 0;

    $p = 1;
    $n = $floor;
    $d = $check - $floor ** 2;
     
    while (1 == 1) {
        my $next = int(($n+$floor)/$d);
     
        push @res, $next;

        $p = $d;
        $n = $next * $d - $n;
        $d = $check - $n ** 2;
     
        $d = $d / $p;
        $p = 1;
     
        last if exists $seen{"$n/$d"};
        $seen{"$n/$d"} = $step++;
    } 

    return $step - $seen{"$n/$d"};
}