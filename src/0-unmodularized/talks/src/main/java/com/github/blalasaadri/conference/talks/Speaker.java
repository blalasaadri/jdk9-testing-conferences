package com.github.blalasaadri.conference.talks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Speaker {

    @Nonnull
    UUID getId();

    @Nonnull
    String getName();

    @Nonnull
    Optional<String> getCompanyOrInstitute();

    @Nonnull
    List<String> getQualifications();

    @Nonnull
    Optional<URL> getURLToImage();

    @Nonnull
    Optional<byte[]> getImage();

}
