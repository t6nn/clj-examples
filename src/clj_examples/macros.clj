(ns clj-examples.macros
  (:gen-class))

(macroexpand '(when (pos? a) (println "positive") (/ b a)))

(defmacro operate [a b]
  `((get [+ - * /] (rand-int 4)) ~a ~b))

(macroexpand '(operate 1 2))
(operate 1 2)
