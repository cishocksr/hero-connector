
CREATE TABLE IF NOT EXISTS resources (
                                         id BIGSERIAL PRIMARY KEY,
                                         name TEXT NOT NULL,
                                         category TEXT NOT NULL,
                                         created_at TIMESTAMPTZ NOT NULL DEFAULT now()
    );
