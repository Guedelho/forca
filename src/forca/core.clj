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

(defn avalia-chute [chute vidas palavra acertos]
  (if (acertou? chute palavra)
    (jogo vidas palavra (conj acertos chute))
    (jogo (dec vidas) palavra acertos)))

(defn jogo [vidas palavra acertos]
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra acertos)
      (ganhou)
      (avalia-chute (le-letra!) vidas palavra acertos))))



(defn fib [n]
  (if (or (= n 0) (= n 1)) n
      (+ (fib (- n 1)) (fib (- n 2)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; (require '[forca.core :as forca] :reload)
