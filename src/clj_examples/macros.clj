(ns clj-examples.macros
  (:gen-class))

(macroexpand '(when (pos? a) (println "positive") (/ b a)))

