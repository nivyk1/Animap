-- Baseline schema: minimal tables to verify migration + PostGIS works
CREATE TABLE IF NOT EXISTS app_user (
    id BIGSERIAL PRIMARY KEY,
    auth_sub VARCHAR(255) NOT NULL UNIQUE,
    display_name VARCHAR(255) NOT NULL,
    role VARCHAR(32) NOT NULL DEFAULT 'USER',
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS species (
    id BIGSERIAL PRIMARY KEY,
    common_name VARCHAR(255) NOT NULL,
    scientific_name VARCHAR(255),
    category VARCHAR(128),
    iucn_status VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS sighting (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES app_user(id),
    species_id BIGINT NOT NULL REFERENCES species(id),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    location geography(Point,4326) NOT NULL,
    location_precision_m INT,
    taken_at TIMESTAMPTZ,
    published BOOLEAN NOT NULL DEFAULT FALSE,
    visibility VARCHAR(32) NOT NULL DEFAULT 'public',
    like_count INT NOT NULL DEFAULT 0,
    comment_count INT NOT NULL DEFAULT 0,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_sighting_location ON sighting USING GIST (location);

