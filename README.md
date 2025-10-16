# Commandes dev :
cd kiboro_back/docker/dev
docker-compose -f docker/docker-compose.dev.yml up --build

# Commandes prod :

docker-compose -f docker/docker-compose.prod.yml up -d --build

# Version simple

cd docker/dev
./start-dev.sh

# 🎯 Utilisation rapide :

# Version avancée

cd docker/dev

# Rebuild complet

./dev.sh rebuild

# Démarrage normal

./dev.sh up

# Voir les logs

./dev.sh logs

# Arrêter

./dev.sh down

# Tout nettoyer

./dev.sh clean
