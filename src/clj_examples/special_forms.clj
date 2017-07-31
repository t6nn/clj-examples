(ns clj-examples.special-forms
  (:gen-class))

(def foo 10)           ; static long foo = 10;
(def ^:dynamic bar 20) ; ~ThreadLocal with default -> can use: (binding [bar 44] bar)


(if (= 10 foo) "yes" "no")  ; if(foo == 10) { return "yes"; } else { return "no"; }

(do (+ 1 2) (+ 2 3))   ; { 1+2; return 2+3; }

(let [x 1              ; { final long x = 1;
      y 2]             ;   final long y = 2;
  (+ x y))             ;   return x + y; }

(quote (+ 1 2))        ; ~"1+2" :)

(def somevalue "bar")
@(var somevalue)

(fn [a b] (+ a b))

(defn
  ^{:doc "Find a maximum of two values"
    :test (fn [] (assert (= 10 (max-of-two 2 10))))
    :user/comment "Use something else instead"}
  max-of-two [a b]
  (if (> a b) a b))

(defn max-of
  ([] nil)
  ([x] x)
  ([x y] (if (> x y) x y))
  ([x y & more] (reduce mymax (mymax x y) more)))

(defn constrained-sqr [x]
    {:pre  [(pos? x)]
     :post [(> % 16), (< % 225)]}
    (* x x))

(loop [a 1 b 1]
  (if (< a 10)
    (if (< b 10)
      (do
        (println a "x" b "=" (* a b))
        (recur a (inc b)))
      (recur (inc a) 1))))

(try
  (throw (new RuntimeException "this is an exception"))
  (catch RuntimeException e (println "Got an exception:" (.getMessage e)))
  (finally (println "Done.")))

