#!/bin/bash

# Script de développement avec options
set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

usage() {
    echo "Usage: $0 [options]"
    echo "Options:"
    echo "  up       - Démarre l'application (default)"
    echo "  down     - Arrête l'application"
    echo "  rebuild  - Rebuild complet et démarre"
    echo "  logs     - Affiche les logs"
    echo "  clean    - Nettoie tout (conteneurs, images, volumes)"
}

build_app() {
    echo "📦 Construction de l'image..."
    docker-compose -f docker-compose.dev.yml build
}

start_app() {
    echo "🚀 Démarrage de l'application..."
    docker-compose -f docker-compose.dev.yml up
}

rebuild_app() {
    echo "🔄 Rebuild complet..."
    docker-compose -f docker-compose.dev.yml down
    docker-compose -f docker-compose.dev.yml build --no-cache
    docker-compose -f docker-compose.dev.yml up
}

stop_app() {
    echo "🛑 Arrêt de l'application..."
    docker-compose -f docker-compose.dev.yml down
}

show_logs() {
    echo "📋 Affichage des logs..."
    docker-compose -f docker-compose.dev.yml logs -f
}

clean_all() {
    echo "🧹 Nettoyage complet..."
    docker-compose -f docker-compose.dev.yml down -v --rmi all
    docker system prune -f
}

# Gestion des arguments
case "${1:-up}" in
    "up")
        build_app
        start_app
        ;;
    "rebuild")
        rebuild_app
        ;;
    "down")
        stop_app
        ;;
    "logs")
        show_logs
        ;;
    "clean")
        clean_all
        ;;
    "help")
        usage
        ;;
    *)
        echo "❌ Option non reconnue: $1"
        usage
        exit 1
        ;;
esac