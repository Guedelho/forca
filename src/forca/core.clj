(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Você perdeu"))

(defn jogo [vidas]
  (if (= vidas 0)
    (perdeu)
    (do
      (print vidas)
      (jogo (dec vidas)))))

(defn fib [n]
  (if (or (= n 0) (= n 1)) n
      (+ (fib (- n 1)) (fib (- n 2)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
