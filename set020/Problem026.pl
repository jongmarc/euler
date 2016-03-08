$len = 0;
$answer = 0;

for ($i = 1000; $i > 1; $i--) {
    print $i."\n";
    if ($len >= $i) {
        last;
    }
 
    undef @rems;
    $val = 1;
    $pos = 0;
 
    while ($rems[$val] == 0 && $val != 0) {
        $rems[$val] = $pos;
        $val *= 10; $val %= $i;
        $pos++;
    }
 
    if ($pos - $rems[$val] > $len) {
        
        $answer = $i;
        
        $len = $pos - $rems[$val];
    }

}

print "Answer = ".$answer;