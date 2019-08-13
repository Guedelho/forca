(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn le-letra! [] (read-line))

(defn perdeu [] (print "Você perdeu"))

(defn ganhou [] (print "Você ganhou"))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra] (contains? acertos (str letra))) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos)))

(defn jogo [vidas palavra acertos]
  (cond
    (= vidas 0) (perdeu)
    (acertou-a-palavra-toda? palavra acertos) (ganhou)
    :else
    (let [chute (le-letra!)]
      (if (acertou? chute palavra)
        (do
          (println "Acertou a letra!")
          (recur vidas palavra (conj acertos chute)))
        (do
          (println "Errou a letra! Perdeu vida!")
          (recur (dec vidas) palavra acertos))))))

(defn fib [n]
  (if (or (= n 0) (= n 1)) n
      (+ (fib (- n 1)) (fib (- n 2)))))

(defn fib2 [n]
  (loop [a 1 b 1 numero 2]
    (if
     (= numero n) b
     (recur b (+ a b) (inc numero)))))

(defn soma [n]
  (loop [contador 1 soma 0]
    (if (> contador n) soma
        (recur (inc contador) (+ contador soma)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; (require '[forca.core :as forca] :reload)
