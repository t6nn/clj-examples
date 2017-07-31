(ns clj-examples.basics
  (:gen-class))


; String
"foo"     ; "foo"

; Character
\f   ; 'f'
\newline ; '\n'
\space   ; ' '
\tab     ; '\t'
\return  ; '\r'

; Numbers
1234      ; 1234L
123456789123456789123456789 ; ~ new BigInteger("123456789123456789123456789")
1234.567  ; 1234.567D
1234.567M ; new BigDecimal("1234.567")
1234/567  ; ~ new BigDecimal(1234).divide(new BigDecimal(567))

; Others
true      ; true
false     ; false
nil       ; null / false

:keyword
:namespace/keyword
::keyword

'symbol

; Vectors
["this" "is" 1 "vector"]  ; ArrayList<?>

; Maps
{:key "value" "key" 2}    ; HashMap<?,?>
{:key "value", "key" 2}

; Sets
#{:value "value" 1234}    ; HashSet<?>

; Lists
'(1 2 3)

; Function calls
(+ 1 2 3)
(+ (- 3 2) 1)


; Macro characters
; <-- comment
; 'form         ; = quote a form (do not parse)
; @form         ; = deref a form
; ^{:key "val"} ; = metadata, e.g. for conveying type information to the compiler
; ^String x     ; = ^{:tag java.lang.String} x
; ^:dynamic x   ; = ^{:dynamic true} x

; Dispatch (#)
; #{}
; #"\s*regex"
; #'x           ; = (var x)
; #()           ; = (fn [args] (...))
; #_            ; = Ignore next form (instead of comment, which yields nil)

; ... and some more oddities (`, ~, ~@)
