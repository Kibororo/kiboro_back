#!/bin/bash

# Script pour rebuild et lancer l'app en développement
set -e

echo "🚀 Rebuild et démarrage de l'application en mode développement..."

# Rebuild des images
echo "📦 Reconstruction des images Docker..."
docker-compose -f docker-compose.dev.yml build --no-cache

# Arrêt des conteneurs existants
echo "🛑 Arrêt des conteneurs existants..."
docker-compose -f docker-compose.dev.yml down

# Démarrage des conteneurs
echo "✅ Démarrage de l'application..."
docker-compose -f docker-compose.dev.yml up --force-recreate

# Alternative avec logs attachés :
# docker-compose -f docker-compose.dev.yml up --build --force-recreate