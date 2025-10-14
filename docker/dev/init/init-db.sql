-- Créer la base de données si elle n'existe pas
SELECT 'CREATE DATABASE kiboro_db' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kiboro_db')\gexec

-- Se connecter à la nouvelle base de données
\c kiboro_db;

-- Créer la table user
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Créer un index sur l'email pour les performances
CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);

-- Insérer des données de test (optionnel pour le dev)
INSERT INTO users (username, email, password, first_name, last_name) 
VALUES 
('admin', 'admin@tonapp.com', 'hashed_password_123', 'Admin', 'User'),
('johndoe', 'john@tonapp.com', 'hashed_password_456', 'John', 'Doe')
ON CONFLICT (username) DO NOTHING;

-- Afficher les tables créées
\dt