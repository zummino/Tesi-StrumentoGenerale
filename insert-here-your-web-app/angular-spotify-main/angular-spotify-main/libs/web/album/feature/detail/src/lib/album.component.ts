import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { AlbumStore } from '@angular-spotify/web/album/data-access';

@Component({
  selector: 'as-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.scss'],
  providers: [AlbumStore],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AlbumComponent {
  album$ = this.store.album$;
  isAlbumLoading$ = this.store.isCurrentAlbumLoading$;
  isAlbumPlaying$ = this.store.isAlbumPlaying$;
  
    @Input() type: 'Album' | 'Playlist' | 'Artist' | undefined;
  @Input() title: string | undefined;
  @Input() description!: string | null;
  @Input() artist: string | undefined;
  @Input() trackCount: number | undefined;
  @Input() likesCount: number | undefined;
  @Input() followerCount: number | undefined;
  @Input() imageUrl: string | undefined;
  @Input() releaseDate: string | undefined;

  likeMapping: {[k: string]: string} = {'=1': '# like', 'other': '# likes'};
  songMapping: {[k: string]: string} = {'=1': '# song', 'other': '# songs'};
  followerMapping: {[k: string]: string} = {'=1': '# follower', 'other': '# followers'};

  constructor(private store: AlbumStore) {}

  toggleAlbum(isPlaying: boolean, uri: string) {
    this.store.toggleAlbum({
      isPlaying,
      uri
    });
  }
}
