package com.github.blalasaadri.conference.speakers.internal;

import com.github.blalasaadri.conference.talks.Speaker;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URL;
import java.util.*;

import static java.util.Collections.unmodifiableList;
import static java.util.Objects.requireNonNull;

public class SpeakerImpl implements Speaker {

    private UUID id;
    private String name, companyOrInstitute, jobTitle;
    private List<String> qualifications;
    private URL urlToImage;
    private byte[] image;

    private SpeakerImpl(String name, String companyOrInstitute, String jobTitle, Collection<String> qualifications, URL urlToImage, byte[] image) {
        requireNonNull(name, "Everyone has a name. Stand up to yours!");

        this.id = UUID.randomUUID();
        this.name = name;
        this.companyOrInstitute = companyOrInstitute;
        this.jobTitle = jobTitle;
        this.qualifications = new ArrayList<>(qualifications);
        this.urlToImage = urlToImage;
        this.image = image;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Nonnull
    public SpeakerImpl withName(@Nonnull String name) {
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, qualifications, urlToImage, image);
    }

    @Override
    public Optional<String> getCompanyOrInstitute() {
        return Optional.ofNullable(companyOrInstitute);
    }

    @Nonnull
    public SpeakerImpl withCompanyOrInstitute(@Nullable String companyOrInstitute) {
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, qualifications, urlToImage, image);
    }

    @Nonnull
    @Override
    public Optional<String> getJobTitle() {
        return Optional.ofNullable(jobTitle);
    }

    @Nonnull
    public SpeakerImpl withJobTitle(@Nullable String jobTitle) {
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, qualifications, urlToImage, image);
    }

    @Override
    public List<String> getQualifications() {
        return unmodifiableList(qualifications);
    }

    @Nonnull
    public SpeakerImpl withQualifications(@Nullable Collection<String> qualifications) {
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, qualifications, urlToImage, image);
    }

    @Nonnull
    public SpeakerImpl addQualification(@Nonnull String qualification) {
        ArrayList<String> updatedQualifications = new ArrayList<>(qualifications);
        updatedQualifications.add(qualification);
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, updatedQualifications, urlToImage, image);
    }

    @Nonnull
    public SpeakerImpl removeQualification(@Nonnull String qualification) {
        ArrayList<String> updatedQualifications = new ArrayList<>(qualifications);
        updatedQualifications.remove(qualification);
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, updatedQualifications, urlToImage, image);
    }

    @Override
    public Optional<URL> getURLToImage() {
        return Optional.ofNullable(urlToImage);
    }

    @Nonnull
    public SpeakerImpl withURLToImage(@Nullable URL urlToImage) {
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, qualifications, urlToImage, image);
    }

    @Override
    public Optional<byte[]> getImage() {
        return Optional.ofNullable(image)
                .filter(array -> array.length > 0);
    }

    @Nonnull
    public SpeakerImpl withImage(byte[] image) {
        return new SpeakerImpl(name, companyOrInstitute, jobTitle, qualifications, urlToImage, image);
    }

    @Nonnull
    public static SpeakerBuilder builder() {
        return new SpeakerBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpeakerImpl speaker = (SpeakerImpl) o;

        return id.equals(speaker.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "SpeakerImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyOrInstitute='" + companyOrInstitute + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", qualifications=" + qualifications +
                ", urlToImage=" + urlToImage +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public static class SpeakerBuilder {
        private String name, companyOrInstitute, jobTitle;
        private List<String> qualifications;
        private URL urlToImage;
        private byte[] image;

        public SpeakerBuilder() {
            qualifications = new ArrayList<>();
        }

        @Nonnull
        public SpeakerBuilder withName(@Nonnull String name) {
            this.name = name;
            return this;
        }

        @Nonnull
        public SpeakerBuilder withCompanyOrInstitute(@Nullable String companyOrInstitute) {
            this.companyOrInstitute = companyOrInstitute;
            return this;
        }

        @Nonnull
        public SpeakerBuilder withJobTitle(@Nullable String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        @Nonnull
        public SpeakerBuilder withQualifications(@Nonnull  Collection<String> qualifications) {
            this.qualifications = new ArrayList<>(qualifications);
            return this;
        }

        @Nonnull
        public SpeakerBuilder addQualification(@Nonnull String qualification) {
            this.qualifications.add(qualification);
            return this;
        }

        @Nonnull
        public SpeakerBuilder removeQualification(@Nonnull String qualification) {
            this.qualifications.remove(qualification);
            return this;
        }

        @Nonnull
        public SpeakerBuilder withURLToImage(@Nullable URL urlToImage) {
            this.urlToImage = urlToImage;
            return this;
        }

        @Nonnull
        public SpeakerBuilder withImage(byte[] image) {
            this.image = image;
            return this;
        }

        public SpeakerImpl build() {
            return new SpeakerImpl(name, companyOrInstitute, jobTitle, qualifications, urlToImage, image);
        }
    }
}
